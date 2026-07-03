import axios from "axios"
import type {Product} from "../types/Product.ts";

const productApi = axios.create({
    baseURL:"http://localhost:8080/api/v1/products"
})

// GET all products
export const getProducts = () => {
    return productApi.get<Product[]>("/getAll")
}

// disable product
export const disableProduct = (id: number) => {
    return productApi.post(`/${id}/disable`)
}

// enable product
export const enableProduct = (id: number) => {
    return productApi.post(`/${id}/enable`)
}
