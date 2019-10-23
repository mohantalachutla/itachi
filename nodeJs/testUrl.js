const http = require("http");
const url = require("url");
const props = require("./props");


http.createServer((req,res) => {
    res.setHeader("Content-Type","text/html");
    res.statusCode = 200;
    let parsedUrl = url.parse(req.url,true);
    res.write(`<h1>Server starts at ${props.host} : ${props.port}</h1>`);
    console.log(parsedUrl);
    res.write(`<h1> ${parsedUrl} </h1> `);  // unable to display it in HTML format.
    res.write(`<p>${parsedUrl.search}</p>
    <p> ${parsedUrl.query.id}</p>
    <p> ${parsedUrl.query.name}</p>
    <p> ${parsedUrl.query.message}</p>
    `);
    res.end("<br><i>ended</i>");
}).listen(props.port,props.host,() => {
    console.log(`Server starts at ${props.host} : ${props.port}`);
});