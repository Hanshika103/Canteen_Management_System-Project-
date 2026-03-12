let cart = JSON.parse(sessionStorage.getItem('cart')) || [];

function renderCart(){
    const container = document.getElementById('cart-list');
    container.innerHTML = '';
    let total = 0;

    cart.forEach((item, index) => {
        total += item.price * item.quantity;
        const div = document.createElement('div');
        div.className = 'cart-item';
        div.innerHTML = `
            <span>${item.item_name} × ${item.quantity} - ₹${item.price * item.quantity}</span>
            <button onclick="removeFromCart(${index})">Remove</button>
        `;
        container.appendChild(div);
    });

    document.getElementById('total').innerText = 'Total: ₹' + total;
}

function removeFromCart(index){
    cart.splice(index, 1);
    sessionStorage.setItem('cart', JSON.stringify(cart));
    renderCart();
}

document.getElementById('checkout').addEventListener('click', () => {
    if(cart.length === 0){
        alert('Cart is empty!');
        return;
    }
    window.location.href = 'payment.html';
});

renderCart();