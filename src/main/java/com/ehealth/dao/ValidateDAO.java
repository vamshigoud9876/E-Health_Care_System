package com.ehealth.dao;

public class ValidateDAO {
    private String userName;
    private String password;
    public ValidateDAO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public String validate()
    {
        UserDAO uDao = new UserDAO();
        AdminDAO aDao = new AdminDAO();
        DoctorDAO dDao = new DoctorDAO();
        
        int uId = uDao.validateUser(userName, password);
        if(uId != -1)
        	return "User";
        int aId = aDao.validateAdmin(userName, password);
        if(aId != -1)
        	return "Admin";
        int dId = dDao.validateDoctor(userName, password);
        if(dId != -1)
        	return "Doctor";
        else
        	return null;
    }

    
}
