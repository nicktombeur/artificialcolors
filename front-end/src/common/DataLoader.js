const env = process.env.NODE_ENV;
const api = process.env.REACT_APP_API_HOST;

export default class DataLoader {

    static load(lang) {
        let url = env === "development" ? api + "/number?lang=" : "/number?lang=";
        return fetch(url + lang).then((res) => res.json());
    }
}
