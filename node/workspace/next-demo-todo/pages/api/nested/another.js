

// should export one default function
//@route   /api/nested/another
export default (req, res) => {
    res.status(200).send(`
    <h1>Welcome to next api route root page</h1> 
    <h3>Api routes works the same way as next page routes</h3> 
    
    `)
}