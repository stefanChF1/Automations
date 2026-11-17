import { test as base } from '@playwright/test'
import { LoginPage } from './loginPage'
import { ProductsPage } from './ProductsPage'

export const test = base.extend({
    loginPage: async ({ page }, use) => {
        await use(new LoginPage(page))
    },

    productPage: async ({ page }, use) => {
        await use(new ProductsPage(page))
    },
})

export { expect } from '@playwright/test'