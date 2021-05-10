package com.company.ielp.app.service;

import com.company.ielp.app.model.Admin;

public interface AdminService {

    Admin login(Admin admin);

    Admin register(Admin admin);
}
