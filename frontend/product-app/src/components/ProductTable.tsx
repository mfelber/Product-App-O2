import {
    getProducts,
    disableProduct,
    enableProduct
} from "../api/productApi.ts";
import {useEffect, useState} from "react";
import type {Product} from "../types/Product.ts";

export default function ProductTable() {
    const [products, setProducts] = useState<Product[]>([]);
    const [loading, setLoading] = useState(false);

    const loadProducts = async () => {
        setLoading(true);
        const res = await getProducts();
        setProducts(res.data)
        setLoading(false)
    }

    useEffect(() => {
        loadProducts();
    }, []);

    const handleDisable = async (id: number) => {
        await disableProduct(id);
        await loadProducts();
    }

    const handleEnable = async (id: number) => {
        await enableProduct(id);
        await loadProducts();
    };

    if (loading) return <p>Loading</p>

    return (
        <div style={{display: "flex", justifyContent: "center"}}>
            <table style={{textAlign: "center"}} border={1} cellPadding={10}>
                <thead>
                <tr>
                    <th> Názov</th>
                    <th> Cena</th>
                    <th> Stav</th>
                    <th> Akcia</th>
                </tr>
                </thead>
                <tbody>
                {products.map((product) => (
                    <tr key={product.id}>
                        <td>{product.nameSk}</td>
                        <td>{product.price}</td>
                        <td style={{color: product.enabled ? "green" : "red"}}>{product.enabled ? "ON" : "OFF"}</td>
                        <td>{product.enabled ? (
                            <button onClick={() => handleDisable(product.id)}>Disable</button>
                        ) : <button onClick={() => handleEnable(product.id)}>Enable</button>}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    )
}