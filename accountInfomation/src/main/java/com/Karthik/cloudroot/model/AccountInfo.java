package com.Karthik.cloudroot.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class AccountInfo {
	
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountNumber;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private Date dateOfBirth;
	@Column
	private int ssn;
	@Column
	private String emailId;
	@Column
	private String contactNumber;
	@Column
	private String address;
	@Column
	private String mailingAddress;
	@Column
	private String accountType;
	@Column
	private BigDecimal balance;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMailingAddress() {
		return mailingAddress;
	}
	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public AccountInfo(Long id, int accountNumber, String firstName, String lastName, Date dateOfBirth, int ssn,
			String emailId, String contactNumber, String address, String mailingAddress, String accountType,
			BigDecimal balance) {
		super();
		this.id = id;
		this.accountNumber =  (int)(Math.random()*9000000)+1000000;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.ssn = ssn;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.address = address;
		this.mailingAddress = mailingAddress;
		this.accountType = accountType;
		this.balance = balance;
	}
	
	public AccountInfo() {
		
	}
	
	

	
	

}
