import React, {Component} from "react";
import SearchBar from "../../components/searchbar/SearchBar";
import ColorTable from "./ColorTable";
import "./Home.scss";

class FilterableColorTable extends Component {

    constructor(props) {
        super(props);
        this.state = {
            filterText: ""
        };

        this.handleFilterTextChange = this.handleFilterTextChange.bind(this);
    }

    handleFilterTextChange(filterText) {
        this.setState({
            filterText
        });
    }

    render() {
        return (
            <div>
                <div className="search-bar">
                    <SearchBar filterText={this.state.filterText} onFilterTextChange={this.handleFilterTextChange} />
                </div>
                <div className="color-table">
                    <ColorTable colors={this.props.colors} filterText={this.state.filterText} />
                </div>
            </div>
        );
    }

}

export default FilterableColorTable;
