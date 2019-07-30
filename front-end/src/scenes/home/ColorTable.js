import React, {Component} from "react";
import ColorElement from "./ColorElement";

class ColorTable extends Component {

    render() {
        const filterText = this.props.filterText;
        let elements = [];
        this.props.colors
            .filter((color) => !filterText ? true :
                color.code.toLowerCase().indexOf(filterText.toLowerCase()) !== -1
                || color.name.toLowerCase().indexOf(filterText.toLowerCase()) !== -1)
            .forEach(color => elements.push(<ColorElement color={color} key={color.code}/>));

        return (
            <ul className="color-card">
                {elements}
            </ul>
        );
    }

}

export default ColorTable;
