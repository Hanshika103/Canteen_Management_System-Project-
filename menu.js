window.addEventListener('load', () => {
    fetch('http://localhost:8080/YourAppName/MenuServlet')
    .then(res => res.json())
    .then(menuItems => {
        const menuContainer = document.getElementById('menu-list');
        menuContainer.innerHTML = '';

        const foodImages = {
            "Burger": "https://images.pexels.com/photos/31300948/pexels-photo-31300948.jpeg",
            "Pizza": "https://cdn.pixabay.com/photo/2017/12/09/08/18/pizza-3007395_1280.jpg",
            "Fries": "https://cdn.pixabay.com/photo/2016/03/05/19/02/french-fries-1238246_1280.jpg",
            "Coca-Cola": "https://cdn.pixabay.com/photo/2014/12/21/23/28/cola-578914_1280.png"
        };

        menuItems.forEach(item => {
            const div = document.createElement('div');
            div.className = 'menu-item';
            div.innerHTML = `
                <img src="${foodImages[item.item_name] || 'https://via.placeholder.com/150'}" alt="${item.item_name}">
                <h4>${item.item_name}</h4>
                <p>Price: ₹${item.price}</p>
                <button onclick="addToCart(${item.item_id}, '${item.item_name}', ${item.price})">Add to Cart</button>
            `;
            menuContainer.appendChild(div);
        });
    })
    .catch(err => console.error(err));
});

let cart = JSON.parse(sessionStorage.getItem('cart')) || [];

function addToCart(item_id, item_name, price){
    cart.push({item_id, item_name, price, quantity: 1});
    sessionStorage.setItem('cart', JSON.stringify(cart));
    alert(item_name + ' added to cart!');
}