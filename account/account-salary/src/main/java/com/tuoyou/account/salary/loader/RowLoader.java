package com.tuoyou.account.salary.loader;

import com.account.common.dict.VoucherType;
import com.tuoyou.account.common.model.SalaryVoucher;
import com.tuoyou.account.common.model.Voucher;
import com.tuoyou.account.salary.domain.SalaryStatementRecord;
import com.tuoyou.account.salary.transfer.*;
import com.tuoyou.account.voucher.core.Extractor;
import com.tuoyou.account.voucher.core.Loader;
import com.tuoyou.account.voucher.core.VoucherTransfer;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * Created by 刘悦之 on 2019/9/6.
 */
public abstract class RowLoader implements Loader<SalaryStatementRecord,Voucher> {
    protected VoucherTransfer accountDateTransfer;
    protected VoucherTransfer categoryTransfer;
    protected VoucherTransfer attachmentCounterTransfer;
    protected VoucherTransfer remarkTransfer;
    protected VoucherTransfer accountCodeTransfer;
    protected VoucherTransfer amountTransfer;
    protected EmployeeTypeTransfer employeeTypeTransfer;
    protected CounterPartyTransfer counterPartyTransfer;

    public RowLoader() {
        this.accountDateTransfer = new AccountDateTransfer();
        this.categoryTransfer = new CategoryTransfer();
        this.attachmentCounterTransfer = new AttachmentCounterTransfer();
        this.remarkTransfer = new RemarkTransfer();
        this.employeeTypeTransfer = new EmployeeTypeTransfer();
        this.counterPartyTransfer = new CounterPartyTransfer();
        this.accountCodeTransfer = this.initAccountCodeTransfer();
        this.amountTransfer = this.initAmountTransfer();
    }

    protected abstract VoucherTransfer initAccountCodeTransfer();
    protected abstract VoucherTransfer initAmountTransfer();
    protected abstract String getVoucherType();

    public Voucher createVoucher(Extractor<SalaryStatementRecord> extractor) throws Exception {
        SalaryVoucher voucher = new SalaryVoucher();
        voucher.setVoucherType(getVoucherType());
        if(VoucherType.credit.equals(getVoucherType())){
            String accountCode = this.accountCodeTransfer.creditGenerator(extractor);
            if(StringUtils.isNotEmpty(accountCode)){
                String accountDate = this.accountDateTransfer.creditGenerator(extractor);
                String category = this.categoryTransfer.creditGenerator(extractor);
                String attachmentCounter = this.attachmentCounterTransfer.creditGenerator(extractor);
                String remark = this.remarkTransfer.creditGenerator(extractor);
                String amount = this.amountTransfer.creditGenerator(extractor);
                String employeeType = this.employeeTypeTransfer.creditGenerator(extractor);
                String counterParty = this.counterPartyTransfer.creditGenerator(extractor);
                voucher.setAccountCode(accountCode);
                voucher.setAccountDate(accountDate);
                voucher.setCategory(category);
                voucher.setAttachmentCount(Integer.valueOf(attachmentCounter));
                voucher.setRemark(remark);
                voucher.setAmount(new BigDecimal(amount));
                voucher.setEmployeeType(employeeType);
                voucher.setCounterParty(counterParty);
                return voucher;
            }
            else
                return null;
        }
        else {
            String accountCode = this.accountCodeTransfer.debitGenerator(extractor);
            if(StringUtils.isNotEmpty(accountCode)){
                String accountDate = this.accountDateTransfer.debitGenerator(extractor);
                String category = this.categoryTransfer.debitGenerator(extractor);
                String attachmentCounter = this.attachmentCounterTransfer.debitGenerator(extractor);
                String remark = this.remarkTransfer.debitGenerator(extractor);
                String amount = this.amountTransfer.debitGenerator(extractor);
                String employeeType = this.employeeTypeTransfer.creditGenerator(extractor);
                String counterParty = this.counterPartyTransfer.creditGenerator(extractor);
                voucher.setAccountCode(accountCode);
                voucher.setAccountDate(accountDate);
                voucher.setCategory(category);
                voucher.setAttachmentCount(Integer.valueOf(attachmentCounter));
                voucher.setRemark(remark);
                voucher.setAmount(new BigDecimal(amount));
                voucher.setEmployeeType(employeeType);
                voucher.setCounterParty(counterParty);
                return voucher;
            }
            else
                return null;
        }
    }
}
