const socket = new SockJS("/ws");
const stompClient = Stomp.over(socket);

stompClient.connect({}, function()){
console.log('connected to Websocket');

stompClient.subscribe('/topic/orders/', function(message){
console.log('Recieved:', JSON.parse(message.body));
});

const order = {
orderId = '123',
stockItems: [
{
itemId:'item1',
name: 'Item1',
unit:{
unitId: 'u1',
name: 'kg'
},
quantity: 10
}
]
};
stompClient.send('/app/order',{}, JSON.stringify(order));
});