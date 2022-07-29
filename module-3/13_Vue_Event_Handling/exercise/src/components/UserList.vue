<template>        
  <div class="container">
    <table id="tblUsers">
      <thead>
        <tr>
          <th>&nbsp;</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
          <th>Email Address</th>
          <th>Status</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>
            <input type="checkbox" id="selectAll" v-bind:checked = "selectedUserIDs.length" v-on:click="toggleSelectAll()" />
          </td>
          <td>
            <input type="text" id="firstNameFilter" v-model="filter.firstName" />
          </td>
          <td>
            <input type="text" id="lastNameFilter" v-model="filter.lastName" />
          </td>
          <td>
            <input type="text" id="usernameFilter" v-model="filter.username" />
          </td>
          <td>
            <input type="text" id="emailFilter" v-model="filter.emailAddress" />
          </td>
          <td>
            <select id="statusFilter" v-model="filter.status">
              <option value>Show All</option>
              <option value="Active">Active</option>
              <option value="Disabled">Disabled</option>
            </select>
          </td>
          <td>&nbsp;</td>
        </tr>
        <tr v-for="user in filteredList" v-bind:key="user.id" v-bind:class="{ disabled: user.status === 'Disabled' }">
          <td>
            <input type="checkbox" v-bind:id="user.id" v-bind:value="user.id" v-model="selectedUserIDs"/>
          </td>
          <td>{{ user.firstName }}</td>
          <td>{{ user.lastName }}</td>
          <td>{{ user.username }}</td>
          <td>{{ user.emailAddress }}</td>
          <td>{{ user.status }}</td>
          <td>
            <button v-on:click="flipStatus(user.id)" class="btnEnableDisable" v-text = "user.status === 'Active' ? 'Disable' : 'Enable'"></button>
          </td>
        </tr>
      </tbody>
    </table>

    <div class="all-actions">
      <button v-on:click="enableSelectedUsers" v-bind:disabled="actionButtonDisabled">Enable Users</button>
      <button v-on:click="disableSelectedUsers" v-bind:disabled="actionButtonDisabled">Disable Users</button>
      <button v-on:click="deleteSelectedUsers" v-bind:disabled="actionButtonDisabled">Delete Users</button>
    </div>

    <button v-on:click="showForm = !showForm">Add New User</button> <!-- do i need to use toggleShowForm() here and pass it the showForm property, somehow?-->

    <form id="frmAddNewUser" v-show="showForm" v-on:submit.prevent="saveUser">
      <div class="field">
        <label for="firstName">First Name:</label>
        <input type="text" name="firstName" v-model="newUser.firstName"/>
      </div>
      <div class="field">
        <label for="lastName">Last Name:</label>
        <input type="text" name="lastName" v-model="newUser.lastName"/>
      </div>
      <div class="field">
        <label for="username">Username:</label>
        <input type="text" name="username" v-model="newUser.username"/>
      </div>
      <div class="field">
        <label for="emailAddress">Email Address:</label>
        <input type="text" name="emailAddress" v-model="newUser.emailAddress"/>
      </div>
      <button type="submit" class="btn save">Save User</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "user-list",
  data() {
    return {
      isChecked: false,
      selectedUserIDs: [],
      filter: {
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: ""
      },
      newUser: {
        id: null,
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "Active"
      },
      users: [
        {
          id: 1,
          firstName: "John",
          lastName: "Smith",
          username: "jsmith",
          emailAddress: "jsmith@gmail.com",
          status: "Active"
        },
        {
          id: 2,
          firstName: "Anna",
          lastName: "Bell",
          username: "abell",
          emailAddress: "abell@yahoo.com",
          status: "Active"
        },
        {
          id: 3,
          firstName: "George",
          lastName: "Best",
          username: "gbest",
          emailAddress: "gbest@gmail.com",
          status: "Disabled"
        },
        {
          id: 4,
          firstName: "Ben",
          lastName: "Carter",
          username: "bcarter",
          emailAddress: "bcarter@gmail.com",
          status: "Active"
        },
        {
          id: 5,
          firstName: "Katie",
          lastName: "Jackson",
          username: "kjackson",
          emailAddress: "kjackson@yahoo.com",
          status: "Active"
        },
        {
          id: 6,
          firstName: "Mark",
          lastName: "Smith",
          username: "msmith",
          emailAddress: "msmith@foo.com",
          status: "Disabled"
        }
      ],
      showForm: false,    //this should hide the form on loading page
    };
  },
  methods: {
    saveUser() {
      this.users.unshift({
        firstName: this.newUser.firstName,
        lastName: this.lastName,
        username: this.username,
        emailAddress: this.emailAddress,
        status: this.status
      });
      this.user = "";
    },
    // toggleShowForm(showForm) {
      // if(showForm == false) {
      //   showForm = true;
      // } else {
      //   showForm = false;
      // }
    //   return !showForm;  //lolol this is so much faster
    // },
    getButtonText(status) {
      if (status === 'Active') {
        return 'Disable';
      } else {
        return 'Enable';
      }
    },

    flipStatus(id) {
      // const theUserToUpdate = this.users.find(user => user.id === id); 
      
      // if(theUserToUpdate.status === 'Active') {
      //   theUserToUpdate.status = 'Disabled';
      // } else {
      //   theUserToUpdate.status = 'Active';
      // }

      this.users.forEach(user => {
        if(user.id === id) {
          if(user.status === 'Active') {
            user.status = 'Disabled';
          } else {
            user.status = 'Active';
          }
        }
      })
    },

  enableSelectedUsers() {
    this.users.forEach(user => {
      if (this.selectedUserIDs.includes(user.id)) {
        user.status = 'Active';
      }
    });
    this.selectedUserIDs = [];
    // this.isChecked = false;
  },

  disableSelectedUsers() {
    this.users.forEach(user => {
      if (this.selectedUserIDs.includes(user.id)) {
        user.status = 'Disabled';
      }
    });
    this.selectedUserIDs = [];
    // this.isChecked = false;
  },

  deleteSelectedUsers() {
    const newUserList = [];
    this.users.forEach(user => {
      if (!this.selectedUserIDs.includes(user.id)) {
        newUserList.push(user);
      }
    });
    this.users = newUserList;
    this.selectedUserIDs = [];
    // this.isChecked = false;
},

  toggleSelectAll() {
    if (this.selectedUserIDs.length <1) {
        this.users.forEach(user => {
          this.selectedUserIDs.push(user.id);
          // this.isChecked = true; thought this would fix the opposing checkbox issue for toggle -- false.
      })
    } else {
        // this.users.forEach(user => {
        //   this.selectedUserIDs.pop(user.id);
        // })
        this.selectedUserIDs = [];
    }
  },
},

  computed: {

    actionButtonDisabled() {
      return this.selectedUserIDs.length === 0;
  } ,

    filteredList() {
      let filteredUsers = this.users;
      if (this.filter.firstName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.firstName.toLowerCase().includes(this.filter.firstName.toLowerCase())
        );
      }
      if (this.filter.lastName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.lastName
            .toLowerCase()
            .includes(this.filter.lastName.toLowerCase())
        );
      }
      if (this.filter.username != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.username
            .toLowerCase()
            .includes(this.filter.username.toLowerCase())
        );
      }
      if (this.filter.emailAddress != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.emailAddress
            .toLowerCase()
            .includes(this.filter.emailAddress.toLowerCase())
        );
      }
      if (this.filter.status != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.status === this.filter.status
        );
      }
      return filteredUsers;
    }

    // toggleShowForm() {
    //   this.showForm = !this.showForm;
    // },

  }
};
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  margin-bottom: 20px;
}
th {
  text-transform: uppercase;
}
td {
  padding: 10px;
}
tr.disabled {
  color: red;
}
input,
select {
  font-size: 16px;
}

form {
  margin: 20px;
  width: 350px;
}
.field {
  padding: 10px 0px;
}
label {
  width: 140px;
  display: inline-block;
}
button {
  margin-right: 5px;
}
.all-actions {
  margin-bottom: 40px;
}
.btn.save {
  margin: 20px;
  float: right;
}
</style>
