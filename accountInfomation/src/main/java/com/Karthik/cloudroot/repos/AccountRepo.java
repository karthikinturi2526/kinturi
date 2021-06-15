package com.Karthik.cloudroot.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Karthik.cloudroot.model.AccountInfo;


@Repository
public interface AccountRepo extends JpaRepository<AccountInfo, Long> {

}
