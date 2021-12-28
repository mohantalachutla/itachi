

//Api routes works the same way as next page routes


// should export one default function
//@route   /api
export default (req, res) => {

    // req.method, req.body, req.headers
    if(req.method ==="DELETE") null; //monolithic arch, go express or nest

    res.status(200).send(`
    <h1>Welcome to next api route root page</h1> 
    <h3>Api routes works the same way as next page routes</h3> 
    
    `)
}