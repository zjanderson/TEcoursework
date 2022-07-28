<template>
  <table id="tblUsers">
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Email Address</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
      <tr>
        <td><input type="text" id="firstNameFilter"/></td>
        <td><input type="text" id="lastNameFilter"/></td>
        <td><input type="text" id="usernameFilter"/></td>
        <td><input type="text" id="emailFilter"/></td>
        <td>
          <select id="statusFilter">
            <option value="">Show All</option>
            <option value="Active">Active</option>
            <option value="Disabled">Disabled</option>
          </select>
        </td>
      </tr>
      <!-- <tr v-for="user in filteredList"></tr>   NEED TO BIND THIS AND THEN IT SHOULD WORK -->
    </tbody>
  </table>
</template>

<script>
export default {
  name: 'user-list',
  data() {
    return {
      filter: {
        firstName: '',
        lastName: '',
        username: '',
        emailAddress: '',
        status: '',
      },

      users: [
        { firstName: 'John', lastName: 'Smith', username: 'jsmith', emailAddress: 'jsmith@gmail.com', status: 'Active' },
        { firstName: 'Anna', lastName: 'Bell', username: 'abell', emailAddress: 'abell@yahoo.com', status: 'Active' },
        { firstName: 'George', lastName: 'Best', username: 'gbest', emailAddress: 'gbest@gmail.com', status: 'Disabled' },
        { firstName: 'Ben', lastName: 'Carter', username: 'bcarter', emailAddress: 'bcarter@gmail.com', status: 'Active' },
        { firstName: 'Katie', lastName: 'Jackson', username: 'kjackson', emailAddress: 'kjackson@yahoo.com', status: 'Active' },
        { firstName: 'Mark', lastName: 'Smith', username: 'msmith', emailAddress: 'msmith@foo.com', status: 'Disabled' }
      ]
    }
  },

  computed: {
    filteredList() {
      return this.users.filter((user) => {
        if (! user.firstName.toLowerCase().includes(this.filter.firstName.toLowerCase())) {
          return false;
        }
        if (! user.lastName.toLowerCase().includes(this.filter.lastName.toLowerCase())) {
          return false;
        }
        if (! user.userName.toLowerCase().includes(this.filter.userName.toLowerCase())) {
          return false;
        }
        if (! user.emailAddress.toLowerCase().includes(this.filter.emailAddress.toLowerCase())) {
          return false;
        }
        if (this.filter.status !== '' && user.status === this.filter.status) {
          return false;
        }

        return false;

      });
    }
  }

}
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif
}
th {
  text-transform: uppercase
}
td {
  padding: 10px;
}
tr.disabled {
  color: red;
}
input, select {
  font-size: 16px;
}
</style>
