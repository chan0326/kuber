import { createSlice } from "@reduxjs/toolkit";
import { initialState } from "./user.init";
import { findAllUsers,findUserById, findlogin } from "./user.service";

const userThunks = [findAllUsers]
const status = {
    pending:'pending',
    fullfilled : 'fullfilled',
    rejected: 'rejected'
}

const handleFulfilled =  (state: any, {payload}: any) => {
    console.log('------------------ conclusion ---------------')
    state.array = payload
    console.log(state.array)
}

export const userSlice = createSlice({
    name: "user",
    initialState,
    reducers: {},
    extraReducers: builder => {
        const {pending, rejected} = status;

        builder.addCase(findAllUsers.fulfilled, handleFulfilled)
        builder.addCase(findUserById.fulfilled, (state:any, {payload}:any)=>{state.json =payload})
        builder.addCase(findlogin.fulfilled,(state:any,{payload}:any)=>{state.message =payload})
    }
})

export const  getAllUsers = (state: any) => {
    console.log('------------------ Before useSelector ---------------')
    console.log(JSON.stringify(state.user.array))
    return state.user.array;
}
export const  getfindUserById= (state: any) => (state.user.json)
export const  getMessage = (state: any) => (state.user.message)
export const {} = userSlice.actions
export default userSlice.reducer;