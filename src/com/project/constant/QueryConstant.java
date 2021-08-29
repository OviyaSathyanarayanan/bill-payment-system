package com.project.constant;

public class QueryConstant {
    public static final String REGISTER_VENDOR_QUERY = "insert into vendor(ve_name,ve_reg_num,ve_type_id,"
            + "ve_address,ve_country,ve_state,ve_email,ve_contact,ve_site,ve_cer_issue_date,ve_cer_validity_date ,ve_year,"
            + "ve_payment,ve_user_name,ve_password,ve_status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'new')";
    public static final String VALIDATE_VENDOR_QUERY = "select ve_password from vendor where ve_user_name=?";
    public static final String VENDOR_CONTACT_EXIST_QUERY = "select ve_contact from vendor where ve_contact=?";
    public static final String VENDOR_EMAIL_EXIST_QUERY = "select ve_email from vendor where ve_email=?";
    public static final String VENDOR_SITE_EXIST_QUERY = "select ve_site from vendor where ve_site=?";
    public static final String VENDOR_USER_NAME_EXIST_QUERY = "select ve_user_name from vendor where ve_user_name=?";
    public static final String REGISTER_USER_QUERY = "insert into customer(cu_first_name,cu_last_name,cu_age,cu_gender,cu_contact,cu_pan,cu_adhar,cu_user_id,cu_password)"
            + "values(?,?,?,?,?,?,?,?,?)";
    public static final String VALIDATE_USER_QUERY = "Select cu_password from customer where cu_user_id=?";
    public static final String USER_CONTACT_EXIST_QUERY = "Select cu_contact from customer where cu_contact=?";
    public static final String USER_NAME_EXIST_QUERY = "Select cu_user_id from customer where cu_user_id=? ";
    public static final String PAN_EXIST_QUERY = "Select cu_pan from customer where cu_pan=?";
    public static final String AADHAR_EXIST_QUERY = "Select cu_adhar from customer where cu_adhar=? ";
    public static final String GET_VENDOR_LIST_ADMIN = "select * from vendor where ve_status='new'";
    public static final String VENDOR_APPROVAL = "update vendor set ve_status=? where ve_id=?";
    public static final String RETRIVE_VENDOR_QUERY = "select * from vendor where ve_user_name=?";
    public static final String UPDATE_VENDOR_QUERY = "update vendor set ve_email=?,ve_contact=?,ve_site=?,ve_cer_validity_date=?,ve_payment=?,ve_password=? where ve_id=?";
    public static final String SEARCH_VENDOR_QUERY = "select * from vendor join vendor_type on ve_type_id=vt_id where ve_name=? or vt_type_name=? and ve_status='Approve'";
    public static final String GET_VENDOR_LIST_CUSTOMER = "select * from vendor where ve_status='Approve'";
    public static final String VALIDATE_ADMIN_QUERY = "select ad_password from admin where ad_name=?";
    public static final String GET_BILL_DETAILS = "select bi_id,bi_amount,bi_date,bi_pt_id from bill where bi_cu_user_id=?";
    public static final String ENTER_BILL_DETAILS = "insert into bill(bi_amount,bi_date,bi_ve_id,bi_pt_id,bi_cu_user_id) values(?,?,?,?,?)";
    public static final String IS_CARD_EXIST = "select ca_cvv from card where ca_num=?";
    public static final String IS_MOBILE_EXIST = "select ph_upi_id from phone where ph_upi_id=?";
    public static final String IS_ACCOUNT_EXIST = "select * from net_banking where nb_account_number=?";
	public static final String UPDATE_CARD_BILL_DETAILS = "update bill set bi_ca_id=? where bi_id=?";

}
