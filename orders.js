const student_id = sessionStorage.getItem('student_id');
if(!student_id) window.location.href = 'login.html';

fetch(`http://localhost:8080/YourAppName/OrderServlet?student_id=${student_id}`)
.then(res => res.json())
.then(orders => {
    const container = document.getElementById('order-list');
    container.innerHTML = '';

    orders.forEach(order => {
        const div = document.createElement('div');
        div.className = 'order-item';
        div.innerHTML = `
            <p>Order ID: ${order.order_id}</p>
            <p>Items: ${order.items.map(i => i.item_name + ' × ' + i.quantity).join(', ')}</p>
            <p>Total: ₹${order.total_amount}</p>
            <p>Status: ${order.order_status}</p>
            <p>Date: ${new Date(order.order_date).toLocaleString()}</p>
        `;
        container.appendChild(div);
    });
})
.catch(err => console.error(err));