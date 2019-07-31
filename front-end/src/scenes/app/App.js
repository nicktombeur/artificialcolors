import React, {Component} from "react";
import DataLoader from "../../common/DataLoader";
import FilterableColorTable from "../home/FilterableColorTable";
import "./App.scss";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            colors: []
        };
        this.loadColors();
    }

    loadColors() {
        DataLoader
            .load()
            .then((colors) => this.setState({
                colors
            }))
            .catch((error) => console.log(error)); // TODO show error message
    }

    render() {
        return (
            <div className="app">
                <div className="header">
                    <nav>
                        <ul>
                            <li>
                                <a href="/" className="nav-logo">
                                    <img src="favicon.png" alt="logo"/>
                                </a>
                            </li>
                            <li>
                                <p className="nav-item">Artificial Colors</p>
                            </li>
                            <li className="nav-right">

                            </li>
                        </ul>
                    </nav>
                </div>
                <div className="content">
                    <FilterableColorTable colors={this.state.colors}/>
                </div>
            </div>
        );
    }
}

export default App;
