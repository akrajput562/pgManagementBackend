package com.PgManagement.Pg.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import com.PgManagement.Pg.user.entity.MstPg;
import com.PgManagement.Pg.user.entity.RentInfo;
import com.PgManagement.Pg.user.entity.VwRoomLayout;

@Component
public interface PgService {

	MstPg createPG(MstPg pgdat);

	void sendEmail(String email);

	boolean verifyOTP(String email, String otp);

	List<VwRoomLayout> getRoomLayoutsByPgAndUser(String pg_id, String user_id);

	List<Map<String,Object>> getPgDtlsByUserId(long user_id);

	List<Map<String, Object>> getRentNotification(String pgCode);

	RentInfo conformationOfRent(RentInfo bo);

	
}
