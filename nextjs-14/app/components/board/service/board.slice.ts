import { createSlice } from "@reduxjs/toolkit";
import { Pending } from "@mui/icons-material";
import build from "next/dist/build";
import { initialState } from "./board.init";
import { findAllBoards, findBoardById } from "./board.service";

const boardThunks = [findAllBoards]
const status = {
    pending:'pending',
    fullfilled : 'fullfilled',
    rejected: 'rejected'
}

const handleFulfilled =  (state: any, {payload}: any) => {
    state.array = payload
}

const handlePending = (state: any) => {
    
}

const handlerejected = (state: any) => {
    
}

export const boardSlice = createSlice({
    name: "board",
    initialState,
    reducers: {},
    extraReducers: builder => {
        const {pending, rejected} = status;

        builder.addCase(findAllBoards.fulfilled, handleFulfilled)
        builder.addCase(findBoardById.fulfilled, (state: any, {payload}: any)=>{state.json= payload})
        
    }
})

export const getAllBoards  = (state: any) => state.board.array
export const getfindBoardsById  = (state: any) => state.board.json

export const {} = boardSlice.actions
export default boardSlice.reducer;