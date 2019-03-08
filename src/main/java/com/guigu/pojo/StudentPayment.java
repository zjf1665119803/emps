package com.guigu.pojo;

import java.util.Date;

public class StudentPayment {
    private Integer paymentId;

    private Integer studentId;
    
    private StudentInfo studentInfo;
    
    private StaffInfo staffInfo;

    private Integer staffId;

    private String paymentSituation;

    private Integer paymentMethod;

    private Date paymentTime;

    private Double discountAmount;

    private Double shouldAmount;

    private Double realAmount;

    private Double debtAmount;

    private String paymentRemark;

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getPaymentSituation() {
        return paymentSituation;
    }

    public void setPaymentSituation(String paymentSituation) {
        this.paymentSituation = paymentSituation == null ? null : paymentSituation.trim();
    }

    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getShouldAmount() {
        return shouldAmount;
    }

    public void setShouldAmount(Double shouldAmount) {
        this.shouldAmount = shouldAmount;
    }

    public Double getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(Double realAmount) {
        this.realAmount = realAmount;
    }

    public Double getDebtAmount() {
        return debtAmount;
    }

    public void setDebtAmount(Double debtAmount) {
        this.debtAmount = debtAmount;
    }

    public String getPaymentRemark() {
        return paymentRemark;
    }

    public void setPaymentRemark(String paymentRemark) {
        this.paymentRemark = paymentRemark == null ? null : paymentRemark.trim();
    }

	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	public StaffInfo getStaffInfo() {
		return staffInfo;
	}

	public void setStaffInfo(StaffInfo staffInfo) {
		this.staffInfo = staffInfo;
	}

	@Override
	public String toString() {
		return "StudentPayment [paymentId=" + paymentId + ", studentId=" + studentId + ", studentInfo=" + studentInfo
				+ ", staffInfo=" + staffInfo + ", staffId=" + staffId + ", paymentSituation=" + paymentSituation
				+ ", paymentMethod=" + paymentMethod + ", paymentTime=" + paymentTime + ", discountAmount="
				+ discountAmount + ", shouldAmount=" + shouldAmount + ", realAmount=" + realAmount + ", debtAmount="
				+ debtAmount + ", paymentRemark=" + paymentRemark + "]";
	}
    
    
}