package com.PgManagement.Pg.user.serviceImp;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PgManagement.Pg.user.entity.MstOtp;
import com.PgManagement.Pg.user.entity.MstPg;
import com.PgManagement.Pg.user.repo.MstOtpRepo;
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
	@Autowired MstOtpRepo mstOtpRepo;

	@Override
	public MstPg createPG(MstPg pgdat) {
		return pgDataRepo.save(pgdat);
	}



	 @Autowired
	    private JavaMailSender javaMailSender;

	    @Value("${spring.mail.username}")
	    private String fromEmail;
		

	    @Override
	    @Transactional(rollbackFor = Exception.class)
	    public void sendEmail(String emai) {

	        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

	        try {
	        	 int randomNumber = ThreadLocalRandom.current().nextInt(1000, 10000);
	            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	            mimeMessageHelper.setFrom(fromEmail);
	            mimeMessageHelper.setTo(emai);
//	            mimeMessageHelper.setCc("akhil.ictinfracon@gmail.com");
//	            mimeMessageHelper.setBcc("akhil.ictinfracon@gmail.com");
	            mimeMessageHelper.setSubject("OTP");
	            mimeMessageHelper.setText(""+randomNumber);
	           
	            MstOtp saveotp=new MstOtp(emai,""+randomNumber,new Date());
	            MstOtp save = mstOtpRepo.save(saveotp);
	            if(save.getOtp()!="" && save.getOtp()!=null) {
	            	 javaMailSender.send(mimeMessage);
	            }else {
	            	
	            }
	           
	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }

	    }
	    
	    public boolean verifyOTP(String email, String otp) {
	    	String verfiedOtp = mstOtpRepo.getOtpByEmail(email);
	    	if(verfiedOtp.equals(otp)) {
	    		return true;
	    	}else {
	    		return false;
	    	}
	      
	    }
	}
