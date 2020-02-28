import React, {Component} from "react";
import {withTranslation} from "react-i18next";
import "./LanguageSelector.scss";

class LanguageSelector extends Component {

    constructor(props) {
        super(props);
        this.state = {
            currentLanguage: "En",
            showLanguages: false,
        };

        this.showLanguages = this.showLanguages.bind(this);
        this.changeLanguage = this.changeLanguage.bind(this);
    }

    static languages() {
        return [
            {short: "En", code: "en-GB", text: "English"},
            {short: "Nl", code: "nl-BE", text: "Nederlands"},
            {short: "De", code: "de-DE", text: "Deutsch"}
        ];
    }

    render() {
        let dropdown = this.getDropdown();

        return (
            <div className="language-dropdown">
                <div onClick={this.showLanguages} data-testid="toggle">
                    <span>{this.state.currentLanguage}</span>
                    <div className={"arrow " + (this.state.showLanguages ? "up" : "down")}/>
                </div>
                {dropdown}
            </div>
        );
    }

    getDropdown() {
        if (this.state.showLanguages) {
            let languageButtons = [];
            for (let language of LanguageSelector.languages()) {
                languageButtons.push(
                    <li key={language.code}>
                        <button className={this.state.currentLanguage === language.short ? "selected" : ""}
                                onClick={this.changeLanguage.bind(this, language)}>{language.text}
                        </button>
                    </li>);
            }
            return <div className="language-dropdown-content">
                <ul>
                    {languageButtons}
                </ul>
            </div>;
        }
        return null;
    }

    showLanguages() {
        this.setState({showLanguages: !this.state.showLanguages});
    }

    changeLanguage(language) {
        this.props.i18n
            .changeLanguage(language.code)
            .then(() => {
                this.props.onLanguageChanged(language);
                this.setState({showLanguages: false, currentLanguage: language.short})
            });
    }
}

export default withTranslation()(LanguageSelector);
