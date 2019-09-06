package com.tuoyou.account.salary.loader;

import com.tuoyou.account.common.model.Voucher;
import com.tuoyou.account.salary.domain.SalaryStatementRecord;
import com.tuoyou.account.salary.transfer.AccountDateTransfer;
import com.tuoyou.account.salary.transfer.AttachmentCounterTransfer;
import com.tuoyou.account.salary.transfer.CategoryTransfer;
import com.tuoyou.account.salary.transfer.RemarkTransfer;
import com.tuoyou.account.voucher.core.Extractor;
import com.tuoyou.account.voucher.core.VoucherTransfer;

/**
 * Created by 刘悦之 on 2019/9/6.
 */
public abstract class RowLoader implements Loader<SalaryStatementRecord>{
    protected VoucherTransfer accountDateTransfer;
    protected VoucherTransfer categoryTransfer;
    protected VoucherTransfer attachmentCounterTransfer;
    protected VoucherTransfer remarkTransfer;
    protected VoucherTransfer accountCodeTransfer;
    protected VoucherTransfer amountTransfer;

    public RowLoader() {
        this.accountDateTransfer = new AccountDateTransfer();
        this.categoryTransfer = new CategoryTransfer();
        this.attachmentCounterTransfer = new AttachmentCounterTransfer();
        this.remarkTransfer = new RemarkTransfer();
        this.accountCodeTransfer = this.initAccountCodeTransfer();
        this.amountTransfer = this.initAmountTransfer();
    }

    protected abstract VoucherTransfer initAccountCodeTransfer();
    protected abstract VoucherTransfer initAmountTransfer();
    protected abstract String getVoucherType();

    public Voucher createVoucher(Extractor<SalaryStatementRecord> extractor){
        Voucher voucher = new Voucher();
        return voucher;
    }

    public VoucherTransfer getAccountDateTransfer() {
        return accountDateTransfer;
    }

    public VoucherTransfer getCategoryTransfer() {
        return categoryTransfer;
    }

    public VoucherTransfer getAttachmentCounterTransfer() {
        return attachmentCounterTransfer;
    }

    public VoucherTransfer getRemarkTransfer() {
        return remarkTransfer;
    }

    public VoucherTransfer getAccountCodeTransfer() {
        return accountCodeTransfer;
    }

    public VoucherTransfer getAmountTransfer() {
        return amountTransfer;
    }
}
