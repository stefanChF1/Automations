const { expect } = require('@playwright/test');

exports.ProductsPage = class ProductPage{
    constructor(page){
        this.page = page;
        this.button = page.locator("//button[contains(@class,'btn')]");
        this.productsInCart = page.locator("//span[contains(@class,'shopping_cart_badge')]");
        this.cart = page.locator('#shopping_cart_container');
        this.removeButton = page.locator("//button[contains(@name,'remove')]");
        this.checkoutButton = page.getByRole("button",{name:'Checkout'});
        this.firstNameCheckout = page.getByRole('textbox',{name:'First Name'});
        this.lastNameCheckout = page.getByRole('textbox',{name:'Last Name'});
        this.postalCodeCheckout = page.getByRole('textbox',{name:'Zip/Postal Code'});
        this.continueCheckoutButton = page.getByRole('button',{name:'Continue'});
        this.finishButton = page.locator('#finish');
        this.orderCompleteMessage = page.locator("//h2[contains(@class,'complete-header')]");

    }
    async allButtons(){
        await this.button.first().waitFor({ state: 'visible' });
        return await this.button.all();
    }
    async addProduct(index) {
        const buttons = await this.allButtons();
        if (!Number.isInteger(index) || index < 0 || index >= buttons.length) {
            throw new Error(`Invalid product index: ${index}`);
        }
        await buttons[index].click();
    }
    async addLastProduct() {
        await this.button.last().click();
    }
    async addFirstProduct(){
        await this.button.first().click();
    }
    async checkCart(expectedCount){
       const actualCount = Number(await this.productsInCart.innerText());
       expect(actualCount).toBe(expectedCount);
    }
    async goToCart(){
        await this.cart.click();
    }

    async getRemoveButtonsCart(){
        await this.removeButton.first().waitFor({state: 'visible'});
        return await this.removeButton.all();
    }
    async checkItemsInCart2(index){
        const removeButtons = await this.getRemoveButtonsCart();
        expect(removeButtons.length).toBe(index)
    }
    async checkout(){
        await this.checkoutButton.click();
    }
    async enterFirstName(firstName){
        await this.firstNameCheckout.fill(firstName);
    }
    async enterLastName(lastName){
        await this.lastNameCheckout.fill(lastName);
    }
    async enterPostCode(code){
        await this.postalCodeCheckout.fill(code);
    }
    async continueCheckout(){
        await this.continueCheckoutButton.click();
    }
    async finishCheckout(){
        await this.finishButton.click();
    }
    async verifyOrderIsFinished(){
        const finishMessage = await this.orderCompleteMessage.innerText();
        expect(finishMessage).toBe('Thank you for your order!')
        console.log('Order finished successfully')
    }
};