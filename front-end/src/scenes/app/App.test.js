import React from "react";
import {render, unmountComponentAtNode} from "react-dom";
import {act} from "react-dom/test-utils";
import FilterableColorTable from "../home/FilterableColorTable";
import App from "./App";

let container = null;
beforeEach(() => {
    container = document.createElement("div");
    document.body.appendChild(container);
});

afterEach(() => {
    unmountComponentAtNode(container);
    container.remove();
    container = null;
});

describe("rendering the page", () => {
    it("should show", () => {
        act(() => {
            render(<App/>, container);
        });
        expect(container.querySelector(".nav-logo img").getAttribute("src")).toBe("favicon.png");
        expect(container.querySelector(".nav-item").textContent).toBe("Natural Colors");

    });
});

// TODO test language selection (move to separate react component!!!!)

// TODO test that sub component get's called correct with items? !
/*
it("renders color data", async () => {
    const colors = [{
        code: "E100",
        name: "Curcumin",
        artificial: false
    }];

    jest.spyOn(global, "fetch").mockImplementation(() => Promise.resolve({
        json: () => Promise.resolve(colors)
    }));

    await act(async () => {
        render(<FilterableColorTable colors={colors}/>, container);
    });

    global.fetch.mockRestore();
});*/
