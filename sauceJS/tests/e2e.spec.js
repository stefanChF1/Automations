import { test } from '../pages/base'

test('loginTest', async ({ loginPage, productPage }) => {
    await loginPage.logIn()
    const buttons = await productPage.allButtons()
    await productPage.addProduct(buttons.length - 2)
    await productPage.addLastProduct()
    await productPage.addFirstProduct()
    await productPage.checkCart(3)
    await productPage.goToCart()
    await productPage.checkItemsInCart2(3)
    await productPage.checkout()
    await productPage.enterFirstName('Ssstefan')
    await productPage.enterLastName('Sstoyanov')
    await productPage.enterPostCode('9002')
    await productPage.continueCheckout()
    await productPage.finishCheckout()
    await productPage.verifyOrderIsFinished()
});