package com.globallogic.user.repository;

import com.globallogic.user.model.UserContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cristianfgr on 12-02-20.
 */
@Repository
public interface UserRepository extends JpaRepository <UserContact, String> {

}
