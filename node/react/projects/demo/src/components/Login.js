import React from 'react';
import Utils, {InputComponent} from './Utils';
import "./../css/Login.css";
import { validate } from '@babel/types';

class Login extends React.Component
{
    constructor(props)
    {
        super();
        this.state = {__username:"",__passworld:"",loginStatus:[],errors:[]};
        this.validatePassword = this.validatePassword.bind(this);
        this.validateUserName  = this.validateUserName.bind(this);
        this.handlePassword = this.handlePassword.bind(this);
        this.handleUserName = this.handleUserName.bind(this);
    }

    render()
    {
        return (
                <>
                <form id ="__login_frm" name={this.props.name} action={this.props.action} method={this.props.method}>
                    <InputComponent htmlFor="__username" id="__username" name="UserName" type="text" onChange={this.handleUserName} value = {this.state.__username}/>
                    <InputComponent htmlFor="__password" id="__password" name="Password" type="password" onChange={this.handlePassword} value = {this.state.__passworld}/>
                    <br/><br/>
                    <button type="submit" id ="__login_btn" name="Login">Login</button>
                    <Utils.DisplayError value = {this.state.errors}/>
                    <Utils.DisplaySuccess value = {this.state.loginStatus}/>
                </form>
                </>
            );
    }
    // no need bind it as arrow function bind this by defualt
    onSubmit = () => {
        
    }
    // need to bind it as treditinal function will created under Window(object).
    validateUserName(value)
    {
        var errors = [];
        if(value == "")
        {
            errors.push("Please enter user name");
        }
        if(value.length > 6)
        {
            
            errors.push("Username should not exceed  6 letters");
        }

        if(errors == [])
        {
           return true;
        }
        else
        {
            this.setState({errors});
            return false;
        }
    }
    // need to bind it as treditinal function will created under Window(object).
    handleUserName(event)
    {
        if(this.state.__username !==event.target.value)
        {
            this.validateUserName(event.target.value);
            this.setState({"__username":event.target.value});
        }
    }
    // need to bind it as treditinal function will created under Window(object).
    validatePassword(value)
    {
        var errors = [];
        if(value == "")
        {
            errors.push("Please enter password");
        }
        if(value.length < 8)
        {
            
            errors.push("Password should contain atleast of 8 letters");
        }
        
        if(errors == [])
        {
           return true;
        }
        else
        {
            this.setState({errors});
            return false;
        }
    }
    // need to bind it as treditinal function will created under Window(object).
    handlePassword(event)
    {
        if(this.state.__passworld !==event.target.value)
        {
            this.validatePassword(event.target.value);
            this.setState({"__passworld":event.target.value});
        }
    }
    componentDidMount()
    {
        if(this.state.errors = [])
        {
            //this.setState({loginStatus:["Loing success"]}); // invoke after a successfull render to VDom then update  ADom.
        }     
    }
    componentDidUpdate()
    {

    }
}

export default Login;