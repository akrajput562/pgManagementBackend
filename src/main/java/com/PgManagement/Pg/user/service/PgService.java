package com.PgManagement.Pg.user.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.PgManagement.Pg.user.entity.MstPg;
import com.PgManagement.Pg.user.entity.VwRoomLayout;

@Component
public interface PgService {

	MstPg createPG(MstPg pgdat);

	void sendEmail(String email);

	boolean verifyOTP(String email, String otp);

	List<VwRoomLayout> getRoomLayoutsByPgAndUser(String pg_id, String user_id);

	
}
