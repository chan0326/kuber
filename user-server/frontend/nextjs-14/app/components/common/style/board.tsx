

// const StripedDataGrid = styled(DataGrid)(({ theme }) => ({
//     [`& .${gridClasses.row}.even`]: {
//       backgroundColor: theme.palette.grey[200],
//       '&:hover': {
//         backgroundColor: alpha(theme.palette.primary.main, ODD_OPACITY),
//         '@media (hover: none)': {
//           backgroundColor: 'transparent',
//         },
//       },
//       '&.Mui-selected': {
//         backgroundColor: alpha(
//           theme.palette.primary.main,
//           ODD_OPACITY + theme.palette.action.selectedOpacity,
//         ),
//         '&:hover': {
//           backgroundColor: alpha(
//             theme.palette.primary.main,
//             ODD_OPACITY +
//               theme.palette.action.selectedOpacity +
//               theme.palette.action.hoverOpacity,
//           ),
//           // Reset on touch devices, it doesn't add specificity
//           '@media (hover: none)': {
//             backgroundColor: alpha(
//               theme.palette.primary.main,
//               ODD_OPACITY + theme.palette.action.selectedOpacity,
//             ),
//           },
//         },
//       },
//     },
//   }));