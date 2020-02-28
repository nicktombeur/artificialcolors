import React, {Component} from "react";
import "./Filter.scss";
import {withTranslation} from 'react-i18next';

// TODO rename to filter!
class Filter extends Component {

    constructor(props) {
        super(props);
        this.state = {value: ""};

        this.handleFilterTextChange = this.handleFilterTextChange.bind(this);
    }

    handleFilterTextChange(event) {
        this.props.onFilterTextChange(event.target.value);
    }

    render() {
        const {t} = this.props;

        return (
            <input id="filter"
                   type="search"
                   placeholder={t('filter')}
                   value={this.props.filterText}
                   onChange={this.handleFilterTextChange}/>
        );
    }
}

export default withTranslation()(Filter);
