exports.LoginPage = class LoginPage {
    constructor(page){
        this.page = page;
        this.usernameField = page.locator('#user-name');
        this.passwordField = page.locator('#password');
        this.loginButton = page.locator('#login-button');
        this.availableUsers = page.locator('#login_credentials')
        this.availablePass = page.locator("//div[contains(@class,'login_password')]")
    }
    async logIn(){
        await this.page.goto('https://www.saucedemo.com/');
        const userList = await this.availableUsers.innerText()
        const credentials = userList.split('\n');

        const passList = await this.availablePass.innerText()
        const passwordValid = passList.split('\n')

        await this.usernameField.fill(credentials[1])
        await this.passwordField.fill(passwordValid[1])
        await this.loginButton.click()
    }
}