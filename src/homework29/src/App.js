import logo from './logo.svg';
import './App.css';
import {Route, Routes} from "react-router-dom";
import * as PropTypes from "prop-types";
import Home from "./Components_homework/HomeComponent_h";
import ReposComponents from "./Components_homework/ReposComponent";
import {NavigationBar} from "./Components_homework/NavigationBar";
import ReposDetails from "./Components_homework/RepositoryDetails";
import {PostsComponents} from "./Components_homework/PostComponents";
import HomeComponent from "./Components/HomeComponent";
import AboutComponent from "./Components/AboutComponent";
import Contact from "./Components/Contact";



function App() {
    return (
        <div className = "App">
            <NavigationBar/>
            <Routes>
                <Route path = "/home/:userName" element = {<HomeComponent/>}/>
                <Route path = "/about" element = {<AboutComponent message = "Hello"/>}/>
                <Route path = "/contact" element = {<Contact/>}/>
                <Route path = "/home"  element = {<Home/>}/>
                <Route path = "/"  element = {<Home/>}/>
                <Route path = "/repos"  element = {<ReposComponents/>}/>
                <Route path = "/repos/:repositoryId"  element = {<ReposDetails/>}/>
                <Route path = "/posts"  element = {<PostsComponents/>}/>
            </Routes>
        </div>
    );
}

export default App;