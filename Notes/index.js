// load data from spring server

// plain js code 

fetch('http://localhost:8080/9.Spring-Rest-APP/api/products/')
.then(response=>response.json())
.then(products=>{
    
    let productsDiv=document.querySelector("#products");
    console.log(products);
    productsDiv.innerHTML=JSON.stringify(products);
    
})