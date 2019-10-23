const http = require('http');
const props = require("./props.js")

/* const server = http.createServer((req, res) => {
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/html');
  res.end('<h1>Hello World</h1> <br>');
}); */

const server = http.createServer((req,res) => {
  res.writeHead(200,"Content-Type : text/html");
  res.write("<h1>"+req.url+"</h1>");
  res.end("ended.");
});

/* server.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
}); */

server.listen(props.port, props.host,()=>{
  console.log("server runnign at localhost");
});