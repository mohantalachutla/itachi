
/* with in page folder, file structure is equivelent to url
 * index.js acts as / in that folder
 * must have export default fun
 * mapped to next routing, fs based
*/

import { Welcome } from "../components/greet"

//@route /
export default () => {

    // react or html code here
    return <>
        <h2> Welcome to NEXT</h2>
        <Welcome name="Jack"></Welcome>
    </>
}