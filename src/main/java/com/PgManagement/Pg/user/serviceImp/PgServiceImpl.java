package com.PgManagement.Pg.user.serviceImp;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.PgManagement.Pg.user.entity.MstPg;
import com.PgManagement.Pg.user.repo.MstPgRepo;
import com.PgManagement.Pg.user.service.PgService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class PgServiceImpl implements PgService{

	@Autowired MstPgRepo pgDataRepo;
	
  @Override
	public MstPg createPG(MstPg pgdat) {
		return pgDataRepo.save(pgdat);
	}



	 @Autowired
	    private JavaMailSender javaMailSender;

	    @Value("${spring.mail.username}")
	    private String fromEmail;

	    @Override
	    public void sendEmail() {

	        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

	        try {
	        	 int randomNumber = ThreadLocalRandom.current().nextInt(1000, 10000);
	            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	            mimeMessageHelper.setFrom(fromEmail);
	            mimeMessageHelper.setTo("akhil.ictinfracon@gmail.com");
	            mimeMessageHelper.setCc("akhil.ictinfracon@gmail.com");
	            mimeMessageHelper.setBcc("akhil.ictinfracon@gmail.com");
	            mimeMessageHelper.setSubject("otp");
	            mimeMessageHelper.setText(""+randomNumber);

	            javaMailSender.send(mimeMessage);

	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }

	    }
	}
