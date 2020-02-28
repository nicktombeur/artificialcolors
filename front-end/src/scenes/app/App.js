import React, {Component} from "react";
import DataLoader from "../../common/DataLoader";
import FilterableColorTable from "../home/FilterableColorTable";
import "./App.scss";
import {withTranslation} from "react-i18next";
import LanguageSelector from "../../components/languageSelector/LanguageSelector";
import Dialog from "../../components/dialog/Dialog";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            colors: [],
            error: ""
        };
        this.loadColors = this.loadColors.bind(this);
        this.closeDialog = this.closeDialog.bind(this);

        this.loadColors(this.props.i18n.language);
    }

    loadColors(language) {
        DataLoader
            .load(language)
            .then((colors) => this.setState({
                colors
            }))
            .catch(() => {
                const { t } = this.props;
                this.setState({error: t("load_error")});
            });
    }

    closeDialog() {
        this.setState({
            error: ""
        });
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
                                <p className="nav-item">Natural Colors</p>
                            </li>
                            <li className="nav-right">
                                <LanguageSelector onLanguageChanged={this.loadColors}/>
                            </li>
                        </ul>
                    </nav>
                </div>
                <div className="content">
                    <FilterableColorTable colors={this.state.colors}/>
                    <Dialog message={this.state.error}
                            onClose={this.closeDialog}
                            visible={this.state.error.length > 0}
                            level="error"/>
                </div>
            </div>
        );
    }
}

export default withTranslation()(App);
