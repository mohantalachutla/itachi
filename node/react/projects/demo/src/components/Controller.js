import React, { useState } from 'react';
import Login from './Login';
let welcome = (
    <>
    <h2>React app</h2>
    <p>Welcome back...</p>
    </>
);

function Main()
{
    return <>
        <div id="__main"><Login id="__login_frm" name="login_frm"/></div>
        </>;
}
export default Main;