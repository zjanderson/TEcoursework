import axios from 'axios';

export default {

    getAllForUser() {
        return axios.get('/shopping-list');
    }

}