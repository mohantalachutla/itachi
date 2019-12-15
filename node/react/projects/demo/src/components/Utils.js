import React from 'react';
import './../css/Utils.css';


export function InputComponent(props)
{
    return (
        
        <div id = "__input_div">
            <label htmlFor={props.id}> {props.name}</label>
            <input {...props}/>
        </div>
    );
}
export function DisplayError(props)
{
    var elements = null;
    if(props.value != null && props.value != [])
    {
        elements = props.value.map(element => {
            return <p>{element}</p>
        });
    }
    return <>
        <div id="__error_div">
            {elements}
        </div>
            </>
}
export function DisplayWarn(props)
{
    var elements = null;
    if(props.value != null && props.value != [])
    {
        elements = props.value.map(element => {
            return <p>{element}</p>
        });
    }
    return <>
        <div id="__warn_div">
            {elements}
        </div>
            </>
}
export function DisplaySuccess(props)
{
    var elements = null;
    if(props.value != null && props.value != [])
    {
        elements = props.value.map(element => {
            return <p>{element}</p>
        });
    }
    return <>
        <div id="__success_div">
            {elements}
        </div>
            </>
}
var Utils = {
    InputComponent: InputComponent,
    DisplayError : DisplayError,
    DisplayWarn : DisplayWarn,
    DisplaySuccess : DisplaySuccess
};

export default Utils;