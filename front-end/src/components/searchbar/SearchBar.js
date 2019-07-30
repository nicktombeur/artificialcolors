import React, {Component} from "react";
import "./SearchBar.scss";

class SearchBar extends Component {

    constructor(props) {
        super(props);
        this.state = {value: ""};

        this.handleFilterTextChange = this.handleFilterTextChange.bind(this);
    }

    handleFilterTextChange(event) {
        this.props.onFilterTextChange(event.target.value);
    }

    render() {
        return (
            <input type="text"
                   placeholder="Search..."
                   value={this.props.filterText}
                   onChange={this.handleFilterTextChange}/>
        );
    }
}

export default SearchBar;
