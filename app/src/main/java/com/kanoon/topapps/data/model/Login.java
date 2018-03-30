package com.kanoon.topapps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ehsan on 2/19/2018.
 */

public class Login {
    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Data")
    @Expose
    private Data data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {
        @SerializedName("User")
        @Expose
        private User user;
        @SerializedName("Token")
        @Expose
        private String token;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

    }

    public class User {
        @SerializedName("UserId")
        @Expose
        private Integer userId;
        @SerializedName("Username")
        @Expose
        private Object username;
        @SerializedName("Password")
        @Expose
        private Object password;
        @SerializedName("ConfirmPassword")
        @Expose
        private Object confirmPassword;
        @SerializedName("Name")
        @Expose
        private String name;
        @SerializedName("LastName")
        @Expose
        private String lastName;
        @SerializedName("NationalCode")
        @Expose
        private String nationalCode;
        @SerializedName("Sex")
        @Expose
        private Boolean sex;
        @SerializedName("Email")
        @Expose
        private String email;
        @SerializedName("Mobile")
        @Expose
        private String mobile;
        @SerializedName("RememberMe")
        @Expose
        private Boolean rememberMe;
        @SerializedName("UserType")
        @Expose
        private Integer userType;
        @SerializedName("TypeName")
        @Expose
        private Object typeName;
        @SerializedName("Enabled")
        @Expose
        private Boolean enabled;
        @SerializedName("AuxRankTotal")
        @Expose
        private Integer auxRankTotal;
        @SerializedName("AuxRankSahmie")
        @Expose
        private Integer auxRankSahmie;
        @SerializedName("AuxSahmieType")
        @Expose
        private Integer auxSahmieType;
        @SerializedName("AuxYear")
        @Expose
        private Integer auxYear;
        @SerializedName("AuxGroupCode")
        @Expose
        private Integer auxGroupCode;
        @SerializedName("AuxCourseUni")
        @Expose
        private String auxCourseUni;
        @SerializedName("BankCardNumber")
        @Expose
        private Object bankCardNumber;
        @SerializedName("BankAccountNumber")
        @Expose
        private Object bankAccountNumber;
        @SerializedName("BankCode")
        @Expose
        private Integer bankCode;
        @SerializedName("ProfilePic")
        @Expose
        private String profilePic;
        @SerializedName("IdCardPic")
        @Expose
        private String idCardPic;
        @SerializedName("ResultPic")
        @Expose
        private String resultPic;
        @SerializedName("ProfilePicFile")
        @Expose
        private Object profilePicFile;
        @SerializedName("IdCardPicFile")
        @Expose
        private Object idCardPicFile;

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Object getUsername() {
            return username;
        }

        public void setUsername(Object username) {
            this.username = username;
        }

        public Object getPassword() {
            return password;
        }

        public void setPassword(Object password) {
            this.password = password;
        }

        public Object getConfirmPassword() {
            return confirmPassword;
        }

        public void setConfirmPassword(Object confirmPassword) {
            this.confirmPassword = confirmPassword;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getNationalCode() {
            return nationalCode;
        }

        public void setNationalCode(String nationalCode) {
            this.nationalCode = nationalCode;
        }

        public Boolean getSex() {
            return sex;
        }

        public void setSex(Boolean sex) {
            this.sex = sex;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Boolean getRememberMe() {
            return rememberMe;
        }

        public void setRememberMe(Boolean rememberMe) {
            this.rememberMe = rememberMe;
        }

        public Integer getUserType() {
            return userType;
        }

        public void setUserType(Integer userType) {
            this.userType = userType;
        }

        public Object getTypeName() {
            return typeName;
        }

        public void setTypeName(Object typeName) {
            this.typeName = typeName;
        }

        public Boolean getEnabled() {
            return enabled;
        }

        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }

        public Integer getAuxRankTotal() {
            return auxRankTotal;
        }

        public void setAuxRankTotal(Integer auxRankTotal) {
            this.auxRankTotal = auxRankTotal;
        }

        public Integer getAuxRankSahmie() {
            return auxRankSahmie;
        }

        public void setAuxRankSahmie(Integer auxRankSahmie) {
            this.auxRankSahmie = auxRankSahmie;
        }

        public Integer getAuxSahmieType() {
            return auxSahmieType;
        }

        public void setAuxSahmieType(Integer auxSahmieType) {
            this.auxSahmieType = auxSahmieType;
        }

        public Integer getAuxYear() {
            return auxYear;
        }

        public void setAuxYear(Integer auxYear) {
            this.auxYear = auxYear;
        }

        public Integer getAuxGroupCode() {
            return auxGroupCode;
        }

        public void setAuxGroupCode(Integer auxGroupCode) {
            this.auxGroupCode = auxGroupCode;
        }

        public String getAuxCourseUni() {
            return auxCourseUni;
        }

        public void setAuxCourseUni(String auxCourseUni) {
            this.auxCourseUni = auxCourseUni;
        }

        public Object getBankCardNumber() {
            return bankCardNumber;
        }

        public void setBankCardNumber(Object bankCardNumber) {
            this.bankCardNumber = bankCardNumber;
        }

        public Object getBankAccountNumber() {
            return bankAccountNumber;
        }

        public void setBankAccountNumber(Object bankAccountNumber) {
            this.bankAccountNumber = bankAccountNumber;
        }

        public Integer getBankCode() {
            return bankCode;
        }

        public void setBankCode(Integer bankCode) {
            this.bankCode = bankCode;
        }

        public String getProfilePic() {
            return profilePic;
        }

        public void setProfilePic(String profilePic) {
            this.profilePic = profilePic;
        }

        public String getIdCardPic() {
            return idCardPic;
        }

        public void setIdCardPic(String idCardPic) {
            this.idCardPic = idCardPic;
        }

        public Object getProfilePicFile() {
            return profilePicFile;
        }

        public void setProfilePicFile(Object profilePicFile) {
            this.profilePicFile = profilePicFile;
        }

        public Object getIdCardPicFile() {
            return idCardPicFile;
        }

        public void setIdCardPicFile(Object idCardPicFile) {
            this.idCardPicFile = idCardPicFile;
        }

        public String getResultPic() {
            return resultPic;
        }

        public void setResultPic(String resultPic) {
            this.resultPic = resultPic;
        }
    }


}
