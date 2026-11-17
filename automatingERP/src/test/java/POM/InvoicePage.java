package POM;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static base.BaseTest.getRandomValue;

public class InvoicePage extends BasePage{
    public InvoicePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "1140invoice_status")
    private WebElement invStatus;
    @FindBy(css = "[id$='payment_terms']")
    WebElement paymentTerms;
    @FindBy(id = "1141due_date")
    private WebElement dueDate;
    @FindBy(id = "2013document_comments")
    private WebElement documentComment;
    @FindBy(id = "1139internal_notes")
    private WebElement internalNotes;
    @FindBy(id = "1704invoice_currency")
    private WebElement invCurrency;
    @FindBy(id = "saveButton")
    private WebElement invSaveButton;
    @FindBy(id = "dataEntrySaveSuccess")
    private WebElement invSuccessMessage;


    public void changeStatus(){
        Select invStatusChange = new Select(invStatus);
        invStatusChange.selectByValue("1089");
    }
    public void setPaymentTerms() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentTerms));
        Select payTerms = new Select(paymentTerms);
        String currentValue = payTerms.getFirstSelectedOption().getAttribute("value");
        if (currentValue == null || currentValue.isEmpty()) {
            String terms = getRandomValue(payTerms);
            payTerms.selectByValue(terms);
        }
    }
    public void setDueDate(String ddMMyyyy){
        dueDate.sendKeys(ddMMyyyy);
    }
    public void setDocumentComment(String comment){
        documentComment.sendKeys(comment);
    }
    public void setInternalNotes(String notes){
        internalNotes.sendKeys(notes);
    }
    public void setCurrency(){
        Select invCur = new Select(invCurrency);
        String cur = getRandomValue(invCur);
        invCur.selectByValue(cur);
    }
    public void saveInvoice(){
        invSaveButton.click();
        Assert.assertTrue(invSuccessMessage.getText().contains("Invoices record saved"));
    }
}
