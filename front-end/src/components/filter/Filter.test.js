import React from "react";
import {render, unmountComponentAtNode} from "react-dom";
import {act} from "react-dom/test-utils";
import Filter from "./Filter";
import {I18nextProvider} from "react-i18next";
import i18n from "../../i18nForTests";
import {fireEvent} from "@testing-library/react";

let container = null;
beforeEach(() => {
    // setup a DOM element as a render target
    container = document.createElement("div");
    document.body.appendChild(container);
});

afterEach(() => {
    // cleanup on exiting
    unmountComponentAtNode(container);
    container.remove();
    container = null;
});

describe("rendering the page", () => {
    it("should show a filter input field", () => {
        act(() => {
            render(<Filter/>, container);
        });
        expect(container.querySelector("#filter")).not.toBeNull();
    });

    it("should show placeholder text", () => {
        act(() => {
            render(<I18nextProvider i18n={i18n}><Filter/></I18nextProvider>, container);
        });
        expect(container.querySelector("#filter").placeholder).toBe("Filter...");
    });
});

describe("filtering", () => {
    it("should fire onFilterTextChange", () => {
        let onFilterTextChange = (value) => {
            expect(container.querySelector("#filter").value).toBe(value)
        };
        act(() => {
            render(<Filter onFilterTextChange={onFilterTextChange}/>, container);
        });
        const search = container.querySelector("#filter");
        fireEvent.change(search, {target: {value: "e100"}});
    });
});
