import axios from 'axios';

export default {

    login(username, password) {
        const dto = {
            username,
            password
        };

        return axios.post('/token', dto)
    },

    register() {

    }
}