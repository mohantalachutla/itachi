const http = require("http");
const formidable = require("formidable");
const url = require("url");
const props = require("./props");

http.createServer((req,res) => {
    let parsedUrl = url.parse(req.url);
    console.log("parsedUrl:\n"+parsedUrl.pathname);
    res.writeHead(200,"Content-Type:text/html");
    res.write("<p>redirected to "+parsedUrl.pathname+"</p><br>");
    ///console.log(req);
    console.log(res);
    if(parsedUrl.pathname == "/home")
    {
        console.log("in1");
        let form = new formidable.IncomingForm();
        form.parse(req,(err,fields,files) => {
            // res.write("success");
            console.log(err);
            console.log(fields);
            console.log(files);
            //console.log(req);
            console.log(res);
/*             res.write(`<h4>Username:</h4> <br>${fields.username}<br>`);
            res.write(`<h4>Sex:</h4> <br>${fields.sex}<br>`);
            //res.write(`<h4>Birth Date:</h4> <br>${fields.birthdate}<br>`);
            res.write(`<h4>Mail:</h4> <br>${fields.mail}<br>`);*/
/*             if(fields.password1 == fields.password2)
            {
                res.write("<br><br><br>Account created successfully.");
            }
            else
            {
                res.write("<br><br><br>Failed.");
            } */
        });
        return res.end();
    }
    else if(parsedUrl.pathname == "/signup")
    {
        console.log("in2");
        res.write("<form name='loginform' method='POST' action='/home'>")
        res.write("<div name='div_us'> <p> Username</p> <br> <input type='text' name='username' id='username'/> </div>");
        res.write("<div name='div_pw'> <p> Password</p> <br> <input type='password' name='password' id='password'/> </div>");
        res.write("<div name='div_pw2'> <p> Re-enter password</p> <br> <input type='password' name='password2' id='password2'> </div>");
        res.write("<div name='div_mail'> <p> Mail</p> <br> <input type='text' name='mail' id='mail'/> </div>");
        res.write("<div name='div_sex'> <p> Sex</p> <br> <select name='sex' id='sex'> <option name='male' id='male' value='male' selected>Male</option> <option name='female' id='female' value='female'>Female</option> </select> </div>");
        res.write("<input type='submit' name='signup' id='signup' value ='signup'/> </div>");
        res.write("</from");
        return res.end();
    }
    else
    {
        console.log("in3");
        res.write("<h2> re- direct to /signup</h2>");
        return res.end();
    }
    console.log("response ended");
    //res.end("<br>response ended");
}).listen(props.port,props.host,() => {
    console.log("Server Started.")
});