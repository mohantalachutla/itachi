
const http = require("http");
const process = require("process")


const express = require("express");
const cors = require("cors");
const socketio = require("socket.io");
const app = express();
const _PORT = process.env.PORT || 3100;

const server = new http.createServer(app)
io = new socketio.Server(server);

io.on("connection",(socket) => {
    console.log("user connected");
    socket.on("message",(msg)=>{
        switch(msg){
            case 'hi': socket.emit("message","hi there..");
            case 'how r you ': socket.emit("message","good. you?");
            case 'fine': socket.emit("message","glad to hear...");
            case 'bye': socket.emit("message","ok, bye.");
            default: socket.emit("message","didnt get you");
        }
    });
    
    socket.on("disconnect",() => {
        console.log("user diconnected");
    });
});


//default template folder
app.use(cors())
app.set("views","./views")
app.set("view engine", "ejs")

app.get("/", (req, res) => {
    res.render("index");
});

app.listen(_PORT, () => console.log(`Server listening at port : ${_PORT}`));